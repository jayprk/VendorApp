package com.app.dao;

import java.util.List;

import com.app.model.Document;

public interface IDocumentDao {
	
	public int saveDocument(Document doc);
	public List<Object[]> getDocIdAndName();
	public Document getDocById(int docId);

}
