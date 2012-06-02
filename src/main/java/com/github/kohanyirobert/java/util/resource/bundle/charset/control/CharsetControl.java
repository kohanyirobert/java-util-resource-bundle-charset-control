package com.github.kohanyirobert.java.util.resource.bundle.charset.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

/**
 * {@linkplain Control Resource bundle control} which uses a specific
 * {@linkplain Charset charset} to load {@linkplain ResourceBundle resource
 * bundles} backed by property files.
 */
public final class CharsetControl extends Control {

  private final Charset charset;

  /**
   * Creates a new {@linkplain CharsetControl charset control} using the
   * given {@linkplain Charset charset}.
   * 
   * @param charset the {@linkplain Charset charset} used by this
   * {@linkplain CharsetControl charset control}
   */
  public CharsetControl(Charset charset) {
    this.charset = charset;
  }

  @Override
  // @do-not-check-next-line ParameterNumber
  public ResourceBundle newBundle(
      String baseName,
      Locale locale,
      String format,
      ClassLoader loader,
      boolean reload) throws IllegalAccessException, InstantiationException, IOException {
    // @do-not-check-previous-line ThrowsCount
    String bundleName = toBundleName(baseName, locale);
    String resourceName = toResourceName(bundleName, "properties");
    return "java.properties".equals(format)
        ? newPropertyResourceBundle(resourceName, loader)
        : super.newBundle(baseName, locale, format, loader, reload);
  }

  private ResourceBundle newPropertyResourceBundle(
      String resourceName,
      ClassLoader loader) throws IOException {
    InputStream stream = null;
    InputStreamReader reader = null;
    try {
      stream = loader.getResourceAsStream(resourceName);
      reader = new InputStreamReader(stream, charset);
      return new PropertyResourceBundle(reader);
    } finally {
      if (stream != null)
        stream.close();
      if (reader != null)
        reader.close();
    }
  }
}
