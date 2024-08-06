public class concretePdfDocument implements PdfDocument {
    @Override
    public void open() {
        // TODO Auto-generated method stub
        System.out.println("OPEN PdfFile");
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        System.out.println("Save PdfFile");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        System.out.println("Close PdfFile");
    }
}
