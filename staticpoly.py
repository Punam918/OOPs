class MathOperations:
    @staticmethod
    def add(a, b):
        return a + b

    @staticmethod
    def sub(a, b, c=0):  
        return a - b - c

print(MathOperations.add(5, 10))  
print(MathOperations.sub(6, 7, 8))  
print(MathOperations.sub(6, 7))  