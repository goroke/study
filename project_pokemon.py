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


POKEMONS = ['피카츄', '꼬부기', '파이리']

while True:
    menu = input('1) 포켓몬 생성  '
                 '2) 프로그램 종료 :')

    if menu == '2':
        print('프로그램을 종료합니다.')
        break

    elif menu == '1':
        pokemon = input('  '.join([f'{i}) {name}' for i, name in enumerate(POKEMONS, start=1)]))
        s = input('포켓몬이 사용 가능한 스킬을 "/" 구분자를 이용하여 입력: ')
        mine = Pokemon(POKEMONS[int(pokemon)-1], s.split('/'))
        enemy = Pokemon('샌드백')

        info_attack = input('1) 정보 조회  '
                            '2) 공격 :')

        if info_attack == '1':
            print('귀차나')

        elif info_attack == '2':
            attack = input('\n'.join([f'{i}) {skill}' for i, skill in enumerate(mine.skills, start=1)]))
            mine.attack(enemy, mine.skills[int(attack)-1])

    else:
        print('장난하냐')
