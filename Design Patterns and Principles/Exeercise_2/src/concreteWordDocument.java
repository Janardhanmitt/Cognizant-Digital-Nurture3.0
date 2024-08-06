public class concreteWordDocument implements WordDocument{

    @Override
    public void open() {
        // TODO Auto-generated method stub
        System.out.println("OPEN WordFile");
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        System.out.println("Save WordFile");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        System.out.println("Close WordFile");
    }
    
}