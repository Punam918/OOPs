class animal:
    def makesound(self):
        print("animal sound")

class dog(animal):
    def makesound(self):
        print("Dog barks")

myanimal = dog()

myanimal.makesound()