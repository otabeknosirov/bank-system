# Bank System

Write a program that provides the basic banking services

All the classes are contained in package **BankServices**.

The class **MainClass** in package **Main** provides a few usage examples for the main methods.  

The [JDK documentation](http://softeng.polito.it/courses/docs/api/index.html) is available on a local server.

## R1: Bank Services

The constructor of class **Bank** accepts as argument a string representing the name of the bank; the method **getName()** returns such a name.

The dates of all operations are represented by means of an integer from 1 to 365, corresponding to the day of the current year.

Every bank account activated with a bank is represented by an object of class **Account**.

The method **createAccount()** allows activating an new bank account and accepts three arguments: the name of the account owner, the activation date, and the amount of the initial deposit; the method returns an integer corresponding to the newly created account number (the numbers start with 1 and are incremented by 1 for each new account); the activation of an account represents the first operation performed on it.

The method **getAccount()** accepts an account number and returns the corresponding object of class _Account_; if the number does not match any active account a **InvalidCode** exception is thrown.

The method **deposit()** allows performing a deposit to the account; it accepts as arguments the account number, the date of the deposit, and the amount; if the number does not match any active account a _InvalidCode_ exception is thrown; if the given date precedes that of the last operation on the account, the deposit is performed on the same date as the latest operation.

The method **withdraw()** allow performing a withdrawal from the account; it accepts as arguments the account number, the withdrawal date, and the amount to be withdrawn; if the number does not match any active account a _InvalidCode_ exception is thrown; if the given amount is greater than the account balance an **InvalidValue** is thrown; if the given date precedes that of the last operation on the account, the withdrawal is performed on the same date as the latest operation.

The method **transfer()** allows performing a bank transfer to another account of the same bank; it accepts as arguments the source account number, the destination account number, the date, and the amount; if any of the account numbers does not match any active account a _InvalidCode_ exception is thrown; if the given amount is greater than the source account balance an _InvalidValue_ is thrown; the dates of the operations on the source and destination accounts are defined with the criteria presented above; in any case the operation date on the destination account must be greater or equal to the date on the source account.

The method **deleteAccount()** allows closing an account by withdrawing all the available money; it accepts as arguments the account number and the date, and returns the closed _Account_; if any of the account numbers does not match any active account a _InvalidCode_ exception is thrown; if the given date precedes that of the last operation on the account, the closure is performed on the same date as the latest operation.

## R2: Operations

The abstract class **Operation** represents a generic operation performed on a bank account.

There are two possible operations: deposit (represented by class **Deposit**) and withdrawal (represented by class **Withdrawal**).

Both classes implement the method **toString()**, that returns a string consisting of: the operation date, a comma ("_,_"), the amount of the operation followed by a sign _+_ o _-_ when the operation is respectively a deposit or a withdrawal, without intermediate blanks (Examples: "_5,500.5+_", "_41,158.0-_" ).

The activation of an account implicitly performs a deposit, while the closure implies a withdrawal.

## R3: Accounts

The class **Account** implements the method **toString()**, that returns a string consisting of: the account number, the name of the owner, the date of the latest operation, and the current balance, all separated by commas ("_,_") and without intermediate blanks (e.g. "_4,Paul,35,522.3_").

In addition the class provides the following methods:

**getMovements()** returns the list of all the operations performed on the account, sorted by decreasing dates;

**getDeposits()** returns the list of all the deposits performed in the account, sorted by increasing amounts;

**getWithdrawals()** returns the list of all withdrawals performed on the account, sorted by increasing amounts.

## R4: Reports

The following methods of class _Bank_ provide information about the active accounts opened with the bank (the closed account are ignored):

**getTotalDeposit()** returns the total amount of money currently deposited with the bank (sum of all accounts balances) ;

**getAccounts()** returns the list of all active accounts, sorted by ascending account number;

**getZeroAccounts()** returns the list of all accounts with balance equal to 0;

**getAccountsByBalance()** accepts an amount range and returns the list of active accounts with a balance within the given range, sorted by decreasing balances;
