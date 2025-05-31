'''Imagine running a dog exhibition camp with hundreds of dogs, and you have to keep track of names,ages and date attended for each dog.
How would you desgin simple resuable model for the dogs?'''

class dog:
    def __init__(self,name,age,date):
        self.name = name
        self.age = age
        self.date =date
    
    def displayinfoofdog(self):
        print(f"name: {self.name}, age: {self.age}, date attended: {self.date}")


dog1 = dog('tommy',2,'2025-05-31')
dog2 = dog('jerry',4,'2026-06-98')

dog1.displayinfoofdog()
dog2.displayinfoofdog()


