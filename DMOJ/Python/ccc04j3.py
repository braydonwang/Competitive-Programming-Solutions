adjectives = []
nouns = []

adjective = input()
noun = input()

for i in range(adjective):
    word = raw_input()
    adjectives.append(word)

for i in range(noun):
    word = raw_input()
    nouns.append(word)

for i in range(noun):
    for n in range(adjective):
        print adjectives[n], "as", nouns[i]
