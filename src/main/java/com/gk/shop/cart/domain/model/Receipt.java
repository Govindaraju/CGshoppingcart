package com.gk.shop.cart.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private final List<ReceiptEntry> entires = new ArrayList<>();

	public void addEntry(ReceiptEntry entry) {
		entires.add(entry);
	}

	public int entriesCount() {
		return entires.size();
	}

	public ReceiptEntry getEntry(int index) {
		return entires.get(index);
	}
}
