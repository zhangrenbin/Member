package com.ice.sh1.po;

import java.util.Date;
import java.util.List;

public class Menu {
    private Integer id;

    private Integer pId;

    private String menuCode;

    private String menuName;

    private String img;

    private String description;

    private String menuType;

    private String navigateUrl;

    private String menuLevel;

    private String isShow;

    private Date createDate;

    private Integer createUserId;

    private Integer showOrder;

    private Integer openTarget;
    
    private List<Menu> subMenu;

    public List<Menu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getNavigateUrl() {
        return navigateUrl;
    }

    public void setNavigateUrl(String navigateUrl) {
        this.navigateUrl = navigateUrl == null ? null : navigateUrl.trim();
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel == null ? null : menuLevel.trim();
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public Integer getOpenTarget() {
        return openTarget;
    }

    public void setOpenTarget(Integer openTarget) {
        this.openTarget = openTarget;
    }
}