package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
import com.app.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {
	
	@Autowired
	private IDocumentDao dao;

	@Override
	public int saveDocument(Document doc) {
		return dao.saveDocument(doc);
	}

	@Override
	public List<Object[]> getDocIdAndName() {
		return dao.getDocIdAndName();
	}

	@Override
	public Document getDocById(int docId) {
		return dao.getDocById(docId);
	}

}
