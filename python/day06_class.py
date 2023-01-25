class Pokemon:
    names = []

    def __init__(self, name, skills=None):  # 생성 시 동작 (생성자)
        if name in Pokemon.names:
            raise ValueError('이름 중복')

        self.name = name
        Pokemon.names.append(name)

        if not skills:
            self.skills = []
        else:
            self.skills = skills

        print(f"포켓몬 {name} 생성됨")

    def attack(self, target, skill):
        if skill in self.skills:
            print(f'{self.name}이(가) {skill}을(를) 사용하여 {target.name}을 공격합니다!')
            target.attacked(self)
        else:
            print(f'{self.name}은(는) {skill}을(를) 사용할 줄 모릅니다')

    def attacked(self, attacker):
        print(f'{self.name}: 으악')

    def learn_new_skill(self, skill):
        self.skills.append(skill)

    def say(self, ment):
        print(f'{self.name}: {ment}')


class Magician(Pokemon):
    def force_say(self, target, ment):
        target.say(ment)


pporkkyeckmon = Pokemon('뽉꼨몬')
dimdidmon = Pokemon('딤딛몬')
dimdidmon.attack(pporkkyeckmon, '뱅망뻘트')
pikachu = Pokemon('삐깎쮸', skills=['뱅망벌트'])
pikachu.say('야 내가 보여줄게')
pikachu.attack(pporkkyeckmon, '뱅망벌트')
dimdidmon.say('올ㅋ')
pporkkyeckmon.say('나한테 왜구랭')
t = Magician('이상한 친구')
t.force_say(pikachu, 'bye')
pikachu2 = Magician('삐깎쮸')
