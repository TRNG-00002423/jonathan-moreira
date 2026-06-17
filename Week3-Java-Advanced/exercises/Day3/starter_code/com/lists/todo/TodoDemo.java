public class TodoDemo {
    public static void main(String[] args) {
        // TODO: add tasks, print, complete one, print again
        TodoListManager groceries = new TodoListManager();

        groceries.addTask("Buy Milk");
        System.out.println(groceries.listTasks());

        groceries.addTask("Buy Bananas");
        System.out.println(groceries.listTasks());

        try {
            System.out.println(groceries.getTask(0));
            System.out.println(groceries.getTask(20));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            groceries.completeTask(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(groceries.listTasks());

    }
}