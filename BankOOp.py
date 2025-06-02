from abc import ABC, abstractmethod


class bankaccount(ABC):
    def __init__(self, account_number, owner_name, balance):
        self.__account_number = account_number  
        self.__owner_name = owner_name
        self.__balance = balance


    def deposit(self, amount):
        if amount > 0:
            self.__balance += amount
            print(f"New Balance: {self.__balance}")
        else:
            print("Invalid deposit amount.")

    @abstractmethod
    def withdraw(self, amount):
        pass

    # getter method for displaying account info
    def get_account_info(self):
        return {
            "Account Number": self.__account_number,
            "Account Holder": self.__owner_name,
            "Current Balance": self.__balance
        }

    # getter method for displaying balance as __balance in encapuslated we can't use it directly in subclasses
    def get_balance(self):
        return self.__balance

class savingaccount(bankaccount):
    def __init__(self, account_number, owner_name, balance):
        super().__init__(account_number, owner_name, balance)

    def withdraw(self, amount):
        if amount > 0 and amount <= self.get_balance():  # getter method is used here
            self._bankaccount__balance -= amount  
            print(f"New Balance: {self.get_balance()}")
        else:
            print("Invalid deposit amount.")

account = savingaccount("123456", "Punam Adhikari", 1000)
account.deposit(500) 
account.withdraw(300)  
print(account.get_account_info())  