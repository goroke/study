# subject = ' $ python, data structure, database     $$$'
# print(subject.find('data'), subject.index('data'))
#
# print(subject.find('asd'), subject.index('asd'))

song = """When an eel grabs your arm,
 And it causes great harm,
 That's - a moray!"""

i = song.rfind('m')
print(song[:i] + song[i:].capitalize())