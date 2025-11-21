# Test List


# Other Thoughts
- ~~Rob wants to refactor the duplication for summing with either a comma or newline, but we are deciding to leave it for now~~ because no longer relevant
- Trying to focus on parsing instead of validating, but feel uneasy about not validating (we are not supposed to be validating based on doc)
- Might want to refactor parse further because: right now it's scattered, split into paragraphs and it's a long method, using different transformations
- Review Routine.md
- Refactor test names
- the tests are confusing in initializing a new delimiter, in Rob's opinion
- inside of add callCount is crosscutting concern-ish, could think about AOP or something else
- add() could be a composed method like parse with increment(), parseNumbers(), and sum()
- Add linter that checks for apple sauces
- the functionality from rule 3 states that the delimiter can be comma or new line, without specifying as a new delimiter. but on line 37 in parse we are hardcoding the new line as a delimiter which Rob thinks is confusing
- refactor parse to allow for steps 10 - 12
- finish steps 10 - 12

Remember that we have a temporary gist to store things we want to try