<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <courseList>
    <xsl:for-each select="courseList/course">
      <course>
        <id><xsl:value-of select="编号"/></id>
        <name><xsl:value-of select="名称"/></name>
        <score><xsl:value-of select="学分"/></score>
        <teacher><xsl:value-of select="老师"/></teacher>
        <location><xsl:value-of select="地点"/></location>
      </course>
    </xsl:for-each>
  </courseList>
</xsl:template>
</xsl:stylesheet>