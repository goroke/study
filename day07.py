import math


class Shape:
    def __init__(self):
        pass

    def area(self):
        pass


class Circle(Shape):
    def __init__(self, x, y, radius):
        self.x = x
        self.y = y
        self.radius = radius

    @property
    def area(self):
        return math.pi * self.radius ** 2


class Cylinder(Circle):
    def __init__(self, x, y, radius, height):
        super().__init__(x, y, radius)
        self.height = height


    @property
    def volume(self):
        return super().area * self.height


c = Circle(0, 0, 10)
print(c.area)

cy = Cylinder(0, 0, 10, 10)
print(cy.volume)
