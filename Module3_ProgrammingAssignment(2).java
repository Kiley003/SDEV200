
import java.math.*;

import java.util.Scanner;

class RationalUsingBigInteger extends Number 
    implements Comparable<RationalUsingBigInteger> {
  
  private BigInteger numerator = BigInteger.ZERO;
  private BigInteger denominator = BigInteger.ONE;

  public RationalUsingBigInteger() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }

  public RationalUsingBigInteger(BigInteger numerator, BigInteger denominator) {
    if (denominator.equals(BigInteger.ZERO)) {
      throw new ArithmeticException("Denominator cannot be zero.");
    }

    if (denominator.compareTo(BigInteger.ZERO) < 0) {
      numerator = numerator.negate();
      denominator = denominator.negate();}
    BigInteger gcd = numerator.gcd(denominator);
    this.numerator = numerator.divide(gcd);
    this.denominator = denominator.divide(gcd);
  }

  public BigInteger getNumerator() {
    return numerator;
  
  public BigInteger getDenominator() {
    return denominator;
  }

  public RationalUsingBigInteger add(RationalUsingBigInteger second) {
    BigInteger n = numerator.multiply(second.denominator)
                  .add(denominator.multiply(second.numerator));
    BigInteger d = denominator.multiply(second.denominator);
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger subtract(RationalUsingBigInteger second) {
    BigInteger n = numerator.multiply(second.denominator)
                  .subtract(denominator.multiply(second.numerator));
    BigInteger d = denominator.multiply(second.denominator);
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger multiply(RationalUsingBigInteger second) {
    BigInteger n = numerator.multiply(second.numerator);
    BigInteger d = denominator.multiply(second.denominator);
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger divide(RationalUsingBigInteger second) {
    if (second.numerator.equals(BigInteger.ZERO)) {
      throw new ArithmeticException("Division by zero.");
    }
    BigInteger n = numerator.multiply(second.denominator);
    BigInteger d = denominator.multiply(second.numerator);
    return new RationalUsingBigInteger(n, d);
  }

 @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        if ((this.subtract((PE_13_15_Rational)(other))).getNumerator().equals(BigInteger.ZERO))
            return true;
        else
            return false;
  }

  @Override
  public String toString() {
    if (denominator.equals(BigInteger.ONE)) {
      return numerator.toString();
    } else {
      return numerator + "/" + denominator;
    }
  }

  @Override
  public int intValue() {
    return (int) doubleValue();
  }

  @Override
  public long longValue() {
    return (long) doubleValue();
  }

   @Override 
    public int compareTo(PE_13_15_Rational o) {
        if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0)
            return 1;
        else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0)
            return -1;
        else
            return 0;
  }
}
