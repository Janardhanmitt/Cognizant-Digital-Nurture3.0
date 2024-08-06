public class concreteExcelDocument implements ExcelDocument {
    @Override
    public void open() {
        // TODO Auto-generated method stub
        System.out.println("OPEN ExcelFile");
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        System.out.println("Save ExcelFile");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        System.out.println("Close ExcelFile");
    }
}
