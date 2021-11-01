package com.example.demo.serviceImpl;

import com.example.demo.service.ReadDoc;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;

import java.io.*;

public class ReadDocImpl implements ReadDoc {
    @Override
    public void readDocTest(String path) throws Exception {


        File file = new File("");
        InputStream is =new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(is);
        HWPFDocument doc = new HWPFDocument(is);
        //输出书签信息




    }

    /**
     * 输出书签的相关信息
     * @param bookmarks
     */
    private void printInfo(Bookmarks bookmarks){
        int counts = bookmarks.getBookmarksCount();
        System.out.println("书签的数量："+counts);
        Bookmark bookmark;
        for (int i = 0;i<counts;i++){
            bookmark = bookmarks.getBookmark(i);
            System.out.println("书签" +(i+1)+"的名称是"+bookmark.getName());
            System.out.println("书签的开始"+bookmark.getStart());
            System.out.println("书签的结束"+bookmark.getEnd());
        }
    }

    /**
     * 读取表格
     * 每一个回车符代表一个段落，所以对表格而言，每一个单元格至少包含一个段落，每行结束都是一个段落
     * @param range
     */
    private void readTable(Range range){
        TableIterator tableIterator = new TableIterator(range);
        Table table;
        TableRow row;
        TableCell cell;
        while (tableIterator.hasNext()){
             table = tableIterator.next();
             int rowNumber = table.numRows();
             for (int j=0;j<rowNumber;j++){
                 row = table.getRow(j);
                int cellNumber = row.numCells();
                for (int k=0;k<cellNumber;k++){
                    cell = row.getCell(k);
                    //输出单元格文本
                    System.out.println(cell.text().trim());
                }
             }
        }
    }


    /**
     * 读取列表
     * @param range
     */
    public void readList(Range range){
        int number = range.numParagraphs();
        Paragraph paragraph;
        for (int i=0;i<number;i++){
           paragraph= range.getParagraph(i);
           if (paragraph.isInList()){
               System.out.println("list:"+paragraph.text());
           }
        }




    }
}
