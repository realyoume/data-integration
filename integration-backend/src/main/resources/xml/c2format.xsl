<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <courseList>
    <xsl:for-each select="courseList/course">
      <course>
        <id><xsl:value-of select="Cno"/></id>
        <name><xsl:value-of select="Cnm"/></name>
        <score><xsl:value-of select="Cpt"/></score>
        <teacher><xsl:value-of select="Tec"/></teacher>
        <location><xsl:value-of select="Pla"/></location>
      </course>
    </xsl:for-each>
  </courseList>
</xsl:template>
</xsl:stylesheet>