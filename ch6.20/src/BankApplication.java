import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    private static int size = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("------------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("------------------------------------------------------");
            System.out.print("선택> ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    accountList();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    run = false;
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }

    // 계좌 생성
    private static void createAccount() {
        System.out.println("---------------");
        System.out.println("계좌생성");
        System.out.println("---------------");
        System.out.print("계좌번호: ");
        String accountNo = sc.nextLine();
        System.out.print("예금주: ");
        String ownerName = sc.nextLine();
        System.out.print("초기입금액: ");
        int balance = sc.nextInt();
        sc.nextLine();

        Account account = new Account(accountNo, ownerName, balance);
        accountArray[size++] = account;

        System.out.println("계좌가 생성되었습니다.");
    }

    // 계좌 목록 출력
    private static void accountList() {
        System.out.println("---------------");
        System.out.println("계좌목록");
        System.out.println("---------------");
        for (int i = 0; i < size; i++) {
            System.out.printf("%s\t%s\t%d\n", accountArray[i].getAccountNo(), accountArray[i].getOwnerName(),
                    accountArray[i].getBalance());
        }
    }

    // 예금
    private static void deposit() {
        System.out.println("---------------");
        System.out.println("예금");
        System.out.println("---------------");
        System.out.print("계좌번호: ");
        String accountNo = sc.nextLine();
        System.out.print("예금액: ");
        int amount = sc.nextInt();
        sc.nextLine();

        Account account = findAccount(accountNo);
        if (account == null) {
            System.out.println("해당 계좌가 존재하지 않습니다.");
        } else {
            account.deposit(amount);
            System.out.println("예금이 성공되었습니다.");
        }
    }


    // 출금
    private static void withdraw() {
        System.out.println("---------------");
        System.out.println("출금");
        System.out.println("---------------");
        System.out.print("계좌번호: ");
        String accountNo = sc.nextLine();
        System.out.print("출금액: ");
        int amount = sc.nextInt();
        sc.nextLine();

        Account account = findAccount(accountNo);
        if (account == null) {
            System.out.println("해당 계좌가 존재하지 않습니다.");
        } else if (account.getBalance() < amount) {
            System.out.println("잔액이 부족합니다.");
        } else {
            account.withdraw(amount);
            System.out.println("출금이 성공되었습니다.");
        }
    }

    // Account 배열에서 accountNo와 동일한 Account 객체 찾기
    private static Account findAccount(String accountNo) {
        Account account = null;
        for (int i = 0; i < size; i++) {
            if (accountArray[i].getAccountNo().equals(accountNo)) {
                account = accountArray[i];
                break;
            }
        }
        return account;
    }
}

