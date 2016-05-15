package com.daphne.lazulite.common.plugin.entity;

import com.daphne.lazulite.common.entity.AbstractEntity;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Transient;
import java.io.Serializable;

public abstract class TransientTreeable<ID extends Serializable> extends AbstractEntity<ID> implements Treeable<ID> {

	/**
	 * 标题
	 */
	private String name;
	/**
	 * 点击后前往的地址 菜单才有
	 */
	private String url;

	/**
	 * 父路径
	 */

	private ID parentId;

	private String parentIds;

	private Integer weight;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 是否有叶子节点
	 */
	// @Formula(value = "(select count(*) from sys_resource f_t where
	// f_t.parent_id = id)")
	private boolean hasChildren;

	/**
	 * 是否显示
	 */

	private Boolean show = Boolean.FALSE;

	private String diy;

	/**
	 * 树枝节点默认图标 如果没有默认 空即可
	 *
	 * @return
	 */
	@Transient
	@Override
	public String getBranchDefaultIcon() {
	    return "ztree_branch";
	}

	    public String getDiy() {
			return diy;
		}

	    public String getIcon() {
	        if (!StringUtils.isEmpty(icon)) {
	            return icon;
	        }
	        if (isRoot()) {
	            return getRootDefaultIcon();
	        }
	        if (isLeaf()) {
	            return getLeafDefaultIcon();
	        }
	        return getBranchDefaultIcon();
	    }

	    /**
	     * 树叶节点默认图标 如果没有默认 空即可
	     *
	     * @return
	     */
	    @Transient
	    @Override
	    public String getLeafDefaultIcon() {
	        return "ztree_file";
	    }

	    /**
		 * 树枝节点默认图标 如果没有默认 空即可
		 *
		 * @return
		 */
	    @Transient
		 public String getName() {
		        return name;
		    }
	    @Transient
	    public ID getParentId() {
	        return parentId;
	    }
	    @Transient
	    public String getParentIds() {
	        return parentIds;
	    }

	    /**
	     * 根节点默认图标 如果没有默认 空即可
	     *
	     * @return
	     */
	    @Transient
	    @Override
	    public String getRootDefaultIcon() {
	        return "ztree_root_open";
	    }
	    @Transient
	    @Override
	    public String getSeparator() {
	        return "-";
	    }
	    @Transient
	    public Boolean getShow() {
	        return show;
	    }
	    @Transient
	    public String getUrl() {
			return url;
		}
	    @Transient
	    public Integer getWeight() {
	        return weight;
	    }

	    @Transient
	    @Override
	    public boolean isHasChildren() {
	        return hasChildren;
	    }

	    @Transient
	    @Override
	    public boolean isLeaf() {
	        if (isRoot()) {
	            return false;
	        }
	        if (isHasChildren()) {
	            return false;
	        }

	        return true;
	    }
	    @Transient
	    @Override
	    public boolean isRoot() {
	    	if(getParentId() instanceof Number){
	    		 if (getParentId() != null &&((Number) getParentId()).longValue() == 0) {
	 	            return true;
	 	        }
	    	}
	        return false;
	    }
	    @Transient
	    @Override
	    public String makeSelfAsNewParentIds() {
	        return getParentIds() + getId() + getSeparator();
	    }

	    public void setDiy(String diy) {
			this.diy = diy;
		}

	    public void setHasChildren(boolean hasChildren) {
	        this.hasChildren = hasChildren;
	    }


	    public void setIcon(String icon) {
	        this.icon = icon;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setParentId(ID parentId) {
	        this.parentId = parentId;
	    }

		public void setParentIds(String parentIds) {
	        this.parentIds = parentIds;
	    }

		public void setShow(Boolean show) {
	        this.show = show;
	    }

		public void setUrl(String url) {
			this.url = url;
		}

		public void setWeight(Integer weight) {
	        this.weight = weight;
	    }
	
}
