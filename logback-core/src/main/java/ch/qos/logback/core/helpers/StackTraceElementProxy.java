package ch.qos.logback.core.helpers;

import java.io.Serializable;

public class StackTraceElementProxy implements Serializable {

  private static final long serialVersionUID = -4832130320500439038L;

  final StackTraceElement ste;
  private String steAsString;
  private PackageInfo pi;
  
  StackTraceElementProxy(StackTraceElement ste) {
    if(ste == null) {
      throw new IllegalArgumentException("ste cannot be null");
    }
    this.ste = ste;
  }
  
  public String getSTEAsString() {
    if(steAsString == null) {
      steAsString = "\tat "+ste.toString();
    }
    return steAsString;
  }
  
  public PackageInfo getPI() {
    // compute pi from ste
    return pi;
  }

  @Override
  public int hashCode() {
    return ste.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final StackTraceElementProxy other = (StackTraceElementProxy) obj;
    return ste.equals(other.ste);
  }
  
  @Override
  public String toString() {
    return getSTEAsString();
  }
  
}