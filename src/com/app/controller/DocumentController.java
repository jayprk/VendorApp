package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
public class DocumentController {

	@Autowired
	private IDocumentService service;

	@RequestMapping("/showDocs")
	public String showDocs(ModelMap map) {
		List<Object[]> docs = service.getDocIdAndName();
		map.addAttribute("docs", docs);
		return "MyDocuments";
	}

	@RequestMapping("docUpload")
	public String uploadDoc(@RequestParam("docId") int docId,
			@RequestParam("docData") CommonsMultipartFile file) {
		if (file != null) {
			Document doc = new Document();
			doc.setFileId(docId);
			doc.setFileName(file.getOriginalFilename());
			doc.setFileData(file.getBytes());
			service.saveDocument(doc);
		}
		return "redirect:showDocs";
	}

	@RequestMapping("docDownload")
	public void downloadDoc(@RequestParam("docId") int docId,
			HttpServletResponse resp) {
		Document doc = service.getDocById(docId);

		resp.addHeader("Content-Disposition",
				"attachemnt;filename=" + doc.getFileName());

		try {
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
