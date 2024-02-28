: '
* Approach:
* To show the file content we will use the `cat` command.
* The words.txt file only contains lower case letters and spaces.
* The words are in sentences, so we need to first separate the words line by line.
* To do that we will use the `tr` command. `tr` is used to translate or delete characters.
* In our case, we will translate the spaces into new lines so that each word comes one line after another.
* We also need to use the `s or squeeze-repeats` flag with the `tr` command as there might be multiple spaces.
* Then we need to sort the words (with the `sort` command), so that, same words come together.
* Now, we will use the uniq command. `uniq` is used for matching line operations.
* If we use `c or count` flag with `uniq`, it gives us matching line count
* where the count comes first and the line afterwards (e.g. 3 hello world)
* Now, we will sort again but now we need to sort in descending order, so that we will use `sort -r`.
* Now, we need to print the word first then the frequency, so we will use `awk` for that.
'

cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{print $2, $1}'
