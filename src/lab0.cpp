#include <fstream>
#include <iostream>
#include <string>
#include <map>
#include <utility>
#include <vector>
#include <algorithm>
#include <functional>

class statistics {
private:
    std::map<std::string, int> words;
    int number_of_all_words;
public:
    statistics() {
        number_of_all_words = 0;
    }

    ~statistics() {
        words.clear();
    }

    const std::map<std::string, int> & get_words() const {
        return words;
    }

    const int get_number_of_all_words() const {
        return number_of_all_words;
    }

    void add_word(const std::string& word) {
        ++words[word];
        ++number_of_all_words;
    }

};


class input_statistics {

private:
    std::ifstream & fin;
    statistics & words_in_file;

    bool is_letter_or_digit(unsigned char symbol) {
        return (symbol >= '0' and symbol <= '9') or (symbol >= 'A' and symbol <= 'Z') or (symbol >= 'a' and symbol <= 'z') or (int(symbol) >= 192 and int(symbol) <= 255);
    }

public:
    input_statistics(std::ifstream & fin, statistics & words_in_file) : fin(fin), words_in_file(words_in_file) {}
    ~input_statistics() {}

    void input_data() {
        std::string current_line;
        int i = 0;
        unsigned char symbol;
        std::string current_word;
        while (std::getline(fin, current_line)) {
            i = 0;
            while (i < current_line.length()) {
                symbol = current_line[i];
                if (is_letter_or_digit(symbol)) {
                    current_word += symbol;
                }
                else {
                    if (!current_word.empty()) {
                        words_in_file.add_word(current_word);
                        current_word.erase();
                    }
                }
                ++i;
            }
            if (!current_word.empty()) {
                words_in_file.add_word(current_word);
                current_word.erase();
            }
        }
    }
};


struct word_and_number {
    int number;
    const std::string* word;
};


auto cmp = [](const word_and_number& a, const word_and_number& b)
{
    return a.number > b.number;
};

class output_statistics {

private:
    std::ofstream & fout;
    const statistics & words_in_file;

public:

    output_statistics(std::ofstream & fout, const statistics & words_in_file) : fout(fout), words_in_file(words_in_file) {}
    ~output_statistics() {}

    void output_data() {
        
        std::vector<word_and_number> sort_map;
        for (auto it = words_in_file.get_words().begin(); it != words_in_file.get_words().end(); ++it) {
            word_and_number x;
            x.number = it->second;
            x.word = &(it->first);

            sort_map.push_back(x);
        }
        std::sort(sort_map.begin(), sort_map.end(), cmp);
        for (auto it = sort_map.begin(); it != sort_map.end(); ++it) {
            fout << *(it->word) << ";" << it->number << ";" << double(it->number) / double(words_in_file.get_number_of_all_words()) << std::endl;
        }

        sort_map.clear();
        
    }
};


int main(int argc, char ** argv) {

    setlocale(LC_ALL, "Russian");
    std::ifstream fin(argv[1]);
    std::ofstream fout(argv[2]);
    

    statistics words_in_file;
    input_statistics input(fin, words_in_file);
    input.input_data();
    output_statistics output(fout, words_in_file);
    output.output_data();

    return 0;
}
