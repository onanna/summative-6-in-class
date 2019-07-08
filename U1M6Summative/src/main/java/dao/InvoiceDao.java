package dao;

public interface InvoiceDao {

    Invoice getInvoiceById(int id);
    void deleteInvoice(int id);
    void deleteInvoiceItems(int id);
}
