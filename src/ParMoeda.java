public record ParMoeda(String conversor, String convertido) {
        public ParMoeda {
            if (conversor == null || convertido == null) {
                throw new IllegalArgumentException("Moedas não podem ser nulas");
            }
        }

    @Override
    public String toString() {
        return conversor + "->"+ convertido;
    }
}

