public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setRealImaginary(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber reciprocal() {
        double scale = this.real * this.real + this.imaginary * this.imaginary;
        return new ComplexNumber(this.real / scale, this.imaginary / scale);
    }

    public ComplexNumber plus(ComplexNumber complexNumber) {
        double real = this.real + complexNumber.real;
        double imaginary = this.imaginary + complexNumber.imaginary;
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber minus(ComplexNumber complexNumber) {
        double real = this.real - complexNumber.real;
        double imaginary = this.imaginary - complexNumber.imaginary;
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber multiply(ComplexNumber complexNumber) {
        double real = this.real * complexNumber.real - this.imaginary * complexNumber.imaginary;
        double imaginary = this.real * complexNumber.real + this.imaginary * complexNumber.imaginary;
        return new ComplexNumber(real, imaginary);
    }

    public ComplexNumber divide(ComplexNumber complexNumber) {
        return this.multiply(complexNumber.reciprocal());
    }

    public ComplexNumber scale(double value) {
        double real = this.real * value;
        double imaginary = this.imaginary * value;
        return new ComplexNumber(real, imaginary);
    }

    public String toString() {
        if (this.imaginary == 0) return String.valueOf(real);
        else if (this.real == 0) return imaginary + "i";
        else if (this.imaginary < 0) return real + " - " + (-this.imaginary) + "i";
        return this.real + " + " + this.imaginary + "i";
    }

}