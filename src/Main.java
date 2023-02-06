import java.util.*;

public class Main {
    public static ArrayList<String> list = new ArrayList<>();

    //public static List<String> list = Arrays.asList("Хлеб", "Хлебные палочки", "Молоко", "Сыр", "Сыр со вкусом хлеба", "Сухарики СчастьеХлебовоза"); //Тестим поиск, ищем хлеб)
    public static void main(String[] args) {

        while (true) {
            switch (chooseOperations()) {
                case 1 -> add();
                case 2 -> show();
                case 3 -> delete();
                case 4 -> search();
                case 5 -> System.exit(0);
            }
        }
    }

    public static int chooseOperations() {
        Scanner scanner = new Scanner(System.in);
        List<String> operations = Arrays.asList("Добавить продукт", "Показать корзину", "Удалить продукт", "Поиск");
        Iterator<String> iter = operations.iterator();
        System.out.println("Выберете операцию: ");
        int i = 1;
        while (iter.hasNext()) {
            String currentOperation = iter.next();
            System.out.println(i + "." + currentOperation);
            i++;
        }
        System.out.println(operations.size() + 1 + "." + "Exit");
        return scanner.nextInt();
    }

    public static void add() {
        System.out.println("Какую покупку добавить?");
        Scanner scanner = new Scanner(System.in);
        list.add(toUpperCaseForFirstLetter(scanner.nextLine()));
        show();
    }

    public static void show() {
        System.out.println("Список покупок");
        Iterator<String> iter = list.iterator();
        int i = 1;
        while (iter.hasNext()) {
            System.out.println(i + "." + iter.next());
            i++;
        }
        System.out.println("Всего в списке покупок: " + list.size());
    }

    public static void search() {
        System.out.println("Что ищем?");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();

        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i).toLowerCase();
            if (item.contains(s)) {
                System.out.println(i + 1 + "." + list.get(i));
            }
        }
    }

    public static void delete() throws NumberFormatException {
        show();
        System.out.println("Какую покупку удалить?");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String prod;
        try {
            Integer.parseInt(s);
            prod = list.get(1);
            list.remove(Integer.parseInt(s) - 1);
        } catch (NumberFormatException e) {
            s = toUpperCaseForFirstLetter(s);
            prod = s;
            list.remove(s);
        }
        System.out.println("Покупка '" + prod + "'" + "удалена");
        show();
    }

    private static String toUpperCaseForFirstLetter(String text) {
        StringBuilder builder = new StringBuilder(text);
        //выставляем первый символ заглавным, если это буква
        if (Character.isAlphabetic(text.codePointAt(0))) {
            builder.setCharAt(0, Character.toUpperCase(text.charAt(0)));
        }

        return builder.toString();
    }
}