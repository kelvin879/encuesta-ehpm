package sv.gob.models.permiso;

import javax.persistence.Id;

public class Permiso {

    @Id
    private String id;
    private String codigo;
    private String username;
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Permiso [authority=" + authority + ", codigo=" + codigo + ", id=" + id + ", username=" + username + "]";
    }

    
    
}
