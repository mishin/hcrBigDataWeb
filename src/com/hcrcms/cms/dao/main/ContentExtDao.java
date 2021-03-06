package com.hcrcms.cms.dao.main;

import com.hcrcms.cms.entity.main.ContentExt;
import com.hcrcms.common.hibernate3.Updater;

public interface ContentExtDao {
	public ContentExt findById(Integer id);

	public ContentExt save(ContentExt bean);

	public ContentExt updateByUpdater(Updater<ContentExt> updater);
	
}