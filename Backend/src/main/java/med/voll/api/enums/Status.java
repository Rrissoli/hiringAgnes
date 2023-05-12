package med.voll.api.enums;

public enum Status {
    INICIAR("iniciar"),
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDA("concluida"),
    CANCELADA("cancelada");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
