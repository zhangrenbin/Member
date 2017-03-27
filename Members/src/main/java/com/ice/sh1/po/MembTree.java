package com.ice.sh1.po;


public class MembTree {

	public String getMembAccount() {
		return membAccount;
	}

	public void setMembAccount(String membAccount) {
		this.membAccount = membAccount;
	}

	public String getMembName() {
		return membName;
	}

	public void setMembName(String membName) {
		this.membName = membName;
	}
	
	public MembTree getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(MembTree leftChild) {
		this.leftChild = leftChild;
	}

	public MembTree getRightChild() {
		return rightChild;
	}

	public void setRightChild(MembTree rightChild) {
		this.rightChild = rightChild;
	}

	public Integer getRecommer() {
		return recommer;
	}

	public void setRecommer(Integer recommer) {
		this.recommer = recommer;
	}

	public String getRecommerName() {
		return recommerName;
	}

	public void setRecommerName(String recommerName) {
		this.recommerName = recommerName;
	}

	public String getRecommerAccount() {
		return recommerAccount;
	}

	public void setRecommerAccount(String recommerAccount) {
		this.recommerAccount = recommerAccount;
	}

	private Integer id;
	
	private Integer membId;
	
	private Integer pId;
	
	private String pos;
	
	private String membAccount;
	
	private String membName;
	
	private MembTree leftChild;
	
	private MembTree rightChild;
	
	private Integer recommer;
	
	private String recommerName;
	
	private String recommerAccount;
	
	private MembTree parent;

	public MembTree getParent() {
		return parent;
	}

	public void setParent(MembTree parent) {
		this.parent = parent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMembId() {
		return membId;
	}

	public void setMembId(Integer membId) {
		this.membId = membId;
	}

	public Integer getpId() {
		return pId;
	}
	
	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}
	
	
}
