import java.util.*;

class Persona {
    String nombre;
    String apellidos;
    Date fechaNacimiento;
    String lugarNacimiento;
    int edad;
    double estatura;
    String sexo;
    String nivelEstudios;
    String dni;
    Municipio municipioCensado;
    Direccion direccionCensado;
    Residencia residencia;
    List<Persona> familiares;

    // Constructor
    Persona(String nombre, String apellidos, Date fechaNacimiento, String lugarNacimiento, int edad, double estatura, String sexo, String nivelEstudios, String dni, Municipio municipioCensado, Direccion direccionCensado, Residencia residencia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.edad = edad;
        this.estatura = estatura;
        this.sexo = sexo;
        this.nivelEstudios = nivelEstudios;
        this.dni = dni;
        this.municipioCensado = municipioCensado;
        this.direccionCensado = direccionCensado;
        this.residencia = residencia;
        this.familiares = new ArrayList<>();
    }
}

class Hombre extends Persona {
    String situacionMilitar;

    Hombre(String nombre, String apellidos, Date fechaNacimiento, String lugarNacimiento, int edad, double estatura, String sexo, String nivelEstudios, String dni, Municipio municipioCensado, Direccion direccionCensado, Residencia residencia, String situacionMilitar) {
        super(nombre, apellidos, fechaNacimiento, lugarNacimiento, edad, estatura, sexo, nivelEstudios, dni, municipioCensado, direccionCensado, residencia);
        this.situacionMilitar = situacionMilitar;
    }
}

class Municipio {
    String codigo;
    String nombre;
    int poblacionRegistrada;
    int poblacionResidente;
    List<Distrito> distritos;
    String codigoPostal;

    Municipio(String codigo, String nombre, int poblacionRegistrada, int poblacionResidente, String codigoPostal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poblacionRegistrada = poblacionRegistrada;
        this.poblacionResidente = poblacionResidente;
        this.codigoPostal = codigoPostal;
        this.distritos = new ArrayList<>();
    }
}

class Direccion {
    String calle;
    int numero;
    String codigoPostal;
    Distrito distrito;

    Direccion(String calle, int numero, String codigoPostal, Distrito distrito) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.distrito = distrito;
    }
}

class Residencia {
    Municipio municipio;
    String pais;
    Date fechaInicio;

    Residencia(Municipio municipio, String pais, Date fechaInicio) {
        this.municipio = municipio;
        this.pais = pais;
        this.fechaInicio = fechaInicio;
    }
}

class Distrito {
    String nombre;

    Distrito(String nombre) {
        this.nombre = nombre;
    }
}

class CensoPoblacion {
    public static void main(String[] args) {
        System.out.println("Sistema de Censo de Población en ejecución...");
        
        Municipio municipio = new Municipio("13034", "Ciudad Real", 100000, 95000, "13000");
        Distrito distrito = new Distrito("Centro");
        Direccion direccion = new Direccion("Calle Mayor", 10, "13000", distrito);
        Residencia residencia = new Residencia(municipio, "España", new Date());
        Persona persona = new Persona("Juan", "Perez", new Date(), "Madrid", 30, 1.75, "Masculino", "Universitario", "12345678A", municipio, direccion, residencia);
        
        System.out.println("Persona registrada: " + persona.nombre + " " + persona.apellidos);
        System.out.println("Municipio censado: " + persona.municipioCensado.nombre);
        System.out.println("Dirección: " + persona.direccionCensado.calle + " " + persona.direccionCensado.numero + ", Código Postal: " + persona.direccionCensado.codigoPostal);
    }
} 
