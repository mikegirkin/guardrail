package com.twilio.guardrail.languages

import com.twilio.guardrail.languages.JavaLanguage.JavaTypeName

object JavaLanguage {
  case class JavaTypeName(tpe: com.github.javaparser.ast.`type`.Type) {
    def asString: String          = toString
    override def toString: String = tpe.asString
  }
}

class JavaLanguage extends LanguageAbstraction {

  type Statement = com.github.javaparser.ast.stmt.Statement

  type Import = com.github.javaparser.ast.ImportDeclaration

  // Terms

  type Term       = com.github.javaparser.ast.Node
  type TermName   = com.github.javaparser.ast.expr.Name
  type TermSelect = com.github.javaparser.ast.expr.Name

  // Declarations
  type MethodDeclaration = com.github.javaparser.ast.body.MethodDeclaration

  // Definitions
  type Definition          = com.github.javaparser.ast.body.BodyDeclaration[_ <: com.github.javaparser.ast.body.BodyDeclaration[_]]
  type AbstractClass       = com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
  type ClassDefinition     = com.github.javaparser.ast.body.TypeDeclaration[_ <: com.github.javaparser.ast.body.TypeDeclaration[_]]
  type InterfaceDefinition = com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
  type ObjectDefinition    = Nothing
  type Trait               = com.github.javaparser.ast.body.ClassOrInterfaceDeclaration

  // Functions
  type InstanceMethod = com.github.javaparser.ast.body.MethodDeclaration
  type StaticMethod   = com.github.javaparser.ast.body.MethodDeclaration

  // Values
  type ValueDefinition = com.github.javaparser.ast.body.VariableDeclarator
  type MethodParameter = com.github.javaparser.ast.body.Parameter
  type Type            = com.github.javaparser.ast.`type`.Type
  type TypeName        = JavaTypeName
  type Annotation      = com.github.javaparser.ast.expr.AnnotationExpr

  // Result
  type FileContents = com.github.javaparser.ast.CompilationUnit
}
