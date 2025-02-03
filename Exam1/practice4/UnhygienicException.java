class UnhygienicException extends IllegalStateException {
    public UnhygienicException(Cutlery utensil) {
        super(utensil.toString() + " isn't clean!");
    }
}

