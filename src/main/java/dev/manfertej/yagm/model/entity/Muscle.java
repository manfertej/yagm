package dev.manfertej.yagm.model.entity;

public enum Muscle {

	BICEPS("Biceps"),
	TRICEPS("Triceps"),
	SHOULDER("Shoulder"),
	FOREARMS("Forearms"),
	CHEST("Chest"),
	UPPER_BACK("Upper_Back"),
	LATS("Lats"),
	QUADS("Quads"),
	FEMORAL("Femoral"),
	CALVES("Calves"),
	ABS("Abs");

	private final String label;

	Muscle(String label) {
		this.label = label;
	}

	public String getLabel() { return this.label; };
}
