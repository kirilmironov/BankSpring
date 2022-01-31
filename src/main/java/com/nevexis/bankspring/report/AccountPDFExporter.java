package com.nevexis.bankspring.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.awt.*;

import com.lowagie.text.Font;
import com.nevexis.bankspring.model.Account;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class AccountPDFExporter {
    private List<Account> listAccounts;

    public AccountPDFExporter(List<Account> listAccounts) {
        this.listAccounts = listAccounts;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Account ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Balance", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Egn", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Account account : listAccounts) {
            table.addCell(String.valueOf(account.getId()));
            table.addCell(account.getName());
            table.addCell(account.getBalance().toString());
            table.addCell(account.getEgn());
        }
    }

    public void export(OutputStream out) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, out);

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph paragraph = new Paragraph("List of Accounts", font);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
