<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <courseList>
      <xsl:for-each select="courseList/course">
        <course>
          <编号><xsl:value-of select="id"/></编号>
          <名称><xsl:value-of select="name"/></名称>
          <学分><xsl:value-of select="score"/></学分>
          <老师><xsl:value-of select="teacher"/></老师>
          <地点><xsl:value-of select="location"/></地点>
        </course>
      </xsl:for-each>
    </courseList>
  </xsl:template>
</xsl:stylesheet>