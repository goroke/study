# subject = ' $ python, data structure, database     $$$'
# print(subject.find('data'), subject.index('data'))
#
# print(subject.find('asd'), subject.index('asd'))

song = """When an eel grabs your arm,
 And it causes great harm,
 That's - a moray!"""

i = song.rfind('m')
print(song[:i] + song[i:].title())

song_list = song.rsplit('m', maxsplit=1)
print('M'.join(song_list))

questions = [
    "We don't serve strings around here. Are you a string?",
    "What is said on Father's Day in the forest?",
    "What makes the sound 'Sis! Boom! Bah!'?"
]

# blah blah blah

# print('Dear {salutation} {name}'.format(salutation='asdf', name='dsafsdf'))
