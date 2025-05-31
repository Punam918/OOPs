from abc import ABC, abstractmethod

class BankAccount(ABC):
    def __init__(self, account_number, initial_balance):
        self.__account_number = account_number  # Encapsulation (private) for protected only _
        self.__balance = initial_balance

    @abstractmethod
    def deposit(self, amount):
        pass

    @abstractmethod
    def withdraw(self, amount):
        pass

    def get_account_info(self):
        return f"Account Number: {self.__account_number}, Balance: {self.__balance}"

    def _update_balance(self, amount):  # Protected method
        self.__balance += amount

    def get_balance(self):
        return self.__balance

# Using Inheritance
class SavingAccount(BankAccount):
    def __init__(self, account_number, initial_balance, interest_rate):
        super().__init__(account_number, initial_balance)
        self.__interest_rate = interest_rate

    def deposit(self, amount):
        self._update_balance(amount)  # Encapsulated method

    def withdraw(self, amount):
        if amount <= self.get_balance():
            self._update_balance(-amount)  # Withdraw within balance limit
        else:
            print("Insufficient Funds.")

    def calculate_interest(self):
        return self.get_balance() + (self.get_balance() * self.__interest_rate / 100)  # Corrected Calculation

class CheckingAccount(BankAccount):
    def __init__(self, account_number, initial_balance, overdraft_limit):
        super().__init__(account_number, initial_balance)
        self.__overdraft_limit = overdraft_limit

    def deposit(self, amount):
        self._update_balance(amount)

    def withdraw(self, amount):
        if amount <= self.get_balance() + self.__overdraft_limit:
            self._update_balance(-amount)
        else:
            print("Overdraft limit exceeded.")

# Testing the classes
savings = SavingAccount("123456", 5000, 5)
savings.deposit(1000)
print(savings.get_account_info())
print(f"Interest Earned: {savings.calculate_interest()}")

checking = CheckingAccount("654321", 3000, 1000)
checking.withdraw(3500)
print(checking.get_account_info())