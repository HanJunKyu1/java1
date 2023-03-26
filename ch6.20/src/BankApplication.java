import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    private static int size = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("------------------------------------------------------");
            System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
            System.out.println("------------------------------------------------------");
            System.out.print("����> ");
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
        System.out.println("���α׷� ����");
    }

    // ���� ����
    private static void createAccount() {
        System.out.println("---------------");
        System.out.println("���»���");
        System.out.println("---------------");
        System.out.print("���¹�ȣ: ");
        String accountNo = sc.nextLine();
        System.out.print("������: ");
        String ownerName = sc.nextLine();
        System.out.print("�ʱ��Աݾ�: ");
        int balance = sc.nextInt();
        sc.nextLine();

        Account account = new Account(accountNo, ownerName, balance);
        accountArray[size++] = account;

        System.out.println("���°� �����Ǿ����ϴ�.");
    }

    // ���� ��� ���
    private static void accountList() {
        System.out.println("---------------");
        System.out.println("���¸��");
        System.out.println("---------------");
        for (int i = 0; i < size; i++) {
            System.out.printf("%s\t%s\t%d\n", accountArray[i].getAccountNo(), accountArray[i].getOwnerName(),
                    accountArray[i].getBalance());
        }
    }

    // ����
    private static void deposit() {
        System.out.println("---------------");
        System.out.println("����");
        System.out.println("---------------");
        System.out.print("���¹�ȣ: ");
        String accountNo = sc.nextLine();
        System.out.print("���ݾ�: ");
        int amount = sc.nextInt();
        sc.nextLine();

        Account account = findAccount(accountNo);
        if (account == null) {
            System.out.println("�ش� ���°� �������� �ʽ��ϴ�.");
        } else {
            account.deposit(amount);
            System.out.println("������ �����Ǿ����ϴ�.");
        }
    }


    // ���
    private static void withdraw() {
        System.out.println("---------------");
        System.out.println("���");
        System.out.println("---------------");
        System.out.print("���¹�ȣ: ");
        String accountNo = sc.nextLine();
        System.out.print("��ݾ�: ");
        int amount = sc.nextInt();
        sc.nextLine();

        Account account = findAccount(accountNo);
        if (account == null) {
            System.out.println("�ش� ���°� �������� �ʽ��ϴ�.");
        } else if (account.getBalance() < amount) {
            System.out.println("�ܾ��� �����մϴ�.");
        } else {
            account.withdraw(amount);
            System.out.println("����� �����Ǿ����ϴ�.");
        }
    }

    // Account �迭���� accountNo�� ������ Account ��ü ã��
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

