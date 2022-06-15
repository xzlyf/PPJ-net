package com.xz.ppjnet.service.impl;

import com.xz.ppjnet.service.DocReadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/15 11:16
 */
@Slf4j
@Service
public class DocReadServiceImpl implements DocReadService {
    @Override
    public List<String> readDoc(String filePath) {
        List<String> strings = new ArrayList<>();
        try {

            if (filePath.endsWith(".doc")) {
                FileInputStream fis = new FileInputStream(filePath);
                HWPFDocument doc = new HWPFDocument(fis);
                String doc1 = doc.getDocumentText();
                strings.add(doc1);
                StringBuilder doc2 = doc.getText();
                strings.add(doc2.toString());
                Range rang = doc.getRange();
                String doc3 = rang.text();
                strings.add(doc3);
                fis.close();
            } else if (filePath.endsWith(".docx")) {
                FileInputStream fis = new FileInputStream(filePath);
                XWPFDocument xdoc = new XWPFDocument(fis);
                XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                String doc1 = extractor.getText();
                strings.add(doc1);
                fis.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error("---------文件异常----------");

        } catch (IOException e) {
            e.printStackTrace();
            log.error("---------找不到文件----------");

        }
        return strings;
    }
}
