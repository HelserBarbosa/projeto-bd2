package br.com.unifacisa.projetobd2.util;

import java.util.ArrayList;
import java.util.List;

public class MappedQueries {

	public List<QueryObject> queries = new ArrayList<QueryObject>();

	public List<QueryObject> getQueries() {
		return queries;
	}

	public void setQueries(List<QueryObject> queries) {
		this.queries = queries;
	}
	
	public QueryObject getQueryByKey(String key) {
		return queries.stream().filter(querie -> querie.getKey().equals(key)).findFirst().get();
	}

}
