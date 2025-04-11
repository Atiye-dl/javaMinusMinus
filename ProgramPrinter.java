package compiler;

import gen.javaMinusMinusListener;
import gen.javaMinusMinusParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;



public class ProgramPrinter implements javaMinusMinusListener {


    private int indentation = 0;

    private void printIndented(String text) {
        System.out.println(" ".repeat(indentation * 4) + text);
    }

    @Override
    public void enterProgram(javaMinusMinusParser.ProgramContext ctx) {

    }

    @Override
    public void exitProgram(javaMinusMinusParser.ProgramContext ctx) {

    }

    @Override
    public void enterImportClass(javaMinusMinusParser.ImportClassContext ctx) {
        printIndented("IMPORT");
        printIndented("LIBRARY");
        printIndented("- " + ctx.Identifier().getText());
    }

    @Override
    public void exitImportClass(javaMinusMinusParser.ImportClassContext ctx) {

    }

    @Override
    public void enterMainClass(javaMinusMinusParser.MainClassContext ctx) {
        String classType = ctx.getChild(0).getText().equals("abstract") ? "ABSTRACT CLASS" : "CLASS";
        printIndented(classType + " " + ctx.className.getText());
        if (ctx.getChildCount() > 2 && ctx.getChild(2).getText().equals("extends")) {
            printIndented("EXTENDS " + ctx.Identifier(1).getText());
        }
        indentation++;
        printIndented("METHOD main");
        indentation++;
    }

    @Override
    public void exitMainClass(javaMinusMinusParser.MainClassContext ctx) {
        indentation--;
    }

    @Override
    public void enterClassDeclaration(javaMinusMinusParser.ClassDeclarationContext ctx) {
        String classType = ctx.getChild(0).getText().equals("abstract") ? "ABSTRACT CLASS" : "CLASS";
        printIndented(classType + " " + ctx.className.getText());
        if (ctx.getChildCount() > 2 && ctx.getChild(2).getText().equals("extends")) {
            printIndented("EXTENDS " + ctx.Identifier(1).getText());
        }
        indentation++;
    }

    @Override
    public void exitClassDeclaration(javaMinusMinusParser.ClassDeclarationContext ctx) {
        indentation--;
    }

    @Override
    public void enterInterfaceDeclaration(javaMinusMinusParser.InterfaceDeclarationContext ctx) {

    }

    @Override
    public void exitInterfaceDeclaration(javaMinusMinusParser.InterfaceDeclarationContext ctx) {

    }

    @Override
    public void enterInterfaceMethodDeclaration(javaMinusMinusParser.InterfaceMethodDeclarationContext ctx) {

    }

    @Override
    public void exitInterfaceMethodDeclaration(javaMinusMinusParser.InterfaceMethodDeclarationContext ctx) {

    }

    @Override
    public void enterInterfaceFieldDeclaration(javaMinusMinusParser.InterfaceFieldDeclarationContext ctx) {
        String type = ctx.type().getText();
        String name = ctx.Identifier().getText();
        String value = ctx.expression().getText();
        printIndented("INTERFACE FIELD " + type + " " + name + " = " + value);
    }

    @Override
    public void exitInterfaceFieldDeclaration(javaMinusMinusParser.InterfaceFieldDeclarationContext ctx) {
    }

    @Override
    public void enterFieldDeclaration(javaMinusMinusParser.FieldDeclarationContext ctx) {
        String type = ctx.varDeclaration().type().getText();
        String name = ctx.varDeclaration().Identifier().getText();
        printIndented("FIELD " + type + " " + name);
    }

    @Override
    public void exitFieldDeclaration(javaMinusMinusParser.FieldDeclarationContext ctx) {
    }


    @Override
    public void enterMethodDeclaration(javaMinusMinusParser.MethodDeclarationContext ctx) {
        String override = ctx.getChild(0).getText().equals("@Override") ? "OVERRIDE true" : "OVERRIDE false";
        String accessModifier = ctx.accessModifier() != null ? ctx.accessModifier().getText() : "default";
        String returnType = ctx.type() != null ? ctx.type().getText() : "void";
        printIndented("METHOD " + ctx.Identifier().getText());
        printIndented(override);
        printIndented("ACCESS_MODIFIER " + accessModifier);
        printIndented("RETURN " + returnType);
        indentation++;
    }

    @Override
    public void exitMethodDeclaration(javaMinusMinusParser.MethodDeclarationContext ctx) {
        indentation--;
    }

    @Override
    public void enterAbstractMethodDeclaration(javaMinusMinusParser.AbstractMethodDeclarationContext ctx) {
        printIndented("ABSTRACT METHOD " + ctx.Identifier().getText());
        String accessModifier = ctx.accessModifier() != null ? ctx.accessModifier().getText() : "default";
        String returnType = ctx.type() != null ? ctx.type().getText() : "void";
        printIndented("ACCESS_MODIFIER " + accessModifier);
        printIndented("RETURN_TYPE " + returnType);
    }

    @Override
    public void exitAbstractMethodDeclaration(javaMinusMinusParser.AbstractMethodDeclarationContext ctx) {

    }

    @Override
    public void enterParameterList(javaMinusMinusParser.ParameterListContext ctx) {

    }

    @Override
    public void exitParameterList(javaMinusMinusParser.ParameterListContext ctx) {

    }

    @Override
    public void enterParameter(javaMinusMinusParser.ParameterContext ctx) {

    }

    @Override
    public void exitParameter(javaMinusMinusParser.ParameterContext ctx) {

    }

    @Override
    public void enterMethodBody(javaMinusMinusParser.MethodBodyContext ctx) {

    }

    @Override
    public void exitMethodBody(javaMinusMinusParser.MethodBodyContext ctx) {

    }

    @Override
    public void enterType(javaMinusMinusParser.TypeContext ctx) {

    }

    @Override
    public void exitType(javaMinusMinusParser.TypeContext ctx) {

    }

    @Override
    public void enterJavaType(javaMinusMinusParser.JavaTypeContext ctx) {

    }

    @Override
    public void exitJavaType(javaMinusMinusParser.JavaTypeContext ctx) {

    }

    @Override
    public void enterAccessModifier(javaMinusMinusParser.AccessModifierContext ctx) {

    }

    @Override
    public void exitAccessModifier(javaMinusMinusParser.AccessModifierContext ctx) {

    }

    @Override
    public void enterNestedStatement(javaMinusMinusParser.NestedStatementContext ctx) {

    }

    @Override
    public void exitNestedStatement(javaMinusMinusParser.NestedStatementContext ctx) {

    }

    @Override
    public void enterConstructorDeclaration(javaMinusMinusParser.ConstructorDeclarationContext ctx) {
        printIndented("CONSTRUCTOR " + ctx.Identifier().getText());
        indentation++;

//        if (ctx.parameterList() != null) {
//            printIndented("PARAMETER");
//            indentation++;
//            for (javaMinusMinusParser.ParameterListContext param : ctx.parameterList()) {
//                String type = param.getText();
//                String name = param.Identifier().getText();
//                printIndented(type + " " + name);
//            }
//            indentation--;
//        }

        printIndented("BODY");
        indentation++;
    }

    @Override
    public void exitConstructorDeclaration(javaMinusMinusParser.ConstructorDeclarationContext ctx) {
        indentation--;
        indentation--;
    }


    @Override
    public void enterLocalDeclaration(javaMinusMinusParser.LocalDeclarationContext ctx) {
        String type = ctx.type().getText();
        String name = ctx.Identifier().getText();
        String value = ctx.expression() != null ? ctx.expression().getText() : "0";
        printIndented("DECLARE " + type + " " + name + " = " + value);
    }

    @Override
    public void exitLocalDeclaration(javaMinusMinusParser.LocalDeclarationContext ctx) {

    }

    @Override
    public void enterVarDeclaration(javaMinusMinusParser.VarDeclarationContext ctx) {

    }

    @Override
    public void exitVarDeclaration(javaMinusMinusParser.VarDeclarationContext ctx) {

    }

    @Override
    public void enterVariableAssignmentStatement(javaMinusMinusParser.VariableAssignmentStatementContext ctx) {
        String name = ctx.Identifier().getText();
        String value = ctx.expression().getText();
        printIndented("ASSIGN " + name + " = " + value);
    }

    @Override
    public void exitVariableAssignmentStatement(javaMinusMinusParser.VariableAssignmentStatementContext ctx) {

    }

    @Override
    public void enterArrayAssignmentStatement(javaMinusMinusParser.ArrayAssignmentStatementContext ctx) {

    }

    @Override
    public void exitArrayAssignmentStatement(javaMinusMinusParser.ArrayAssignmentStatementContext ctx) {

    }

    @Override
    public void enterLocalDeclarationStatement(javaMinusMinusParser.LocalDeclarationStatementContext ctx) {

    }

    @Override
    public void exitLocalDeclarationStatement(javaMinusMinusParser.LocalDeclarationStatementContext ctx) {

    }

    @Override
    public void enterIfBlock(javaMinusMinusParser.IfBlockContext ctx) {

    }

    @Override
    public void exitIfBlock(javaMinusMinusParser.IfBlockContext ctx) {

    }

    @Override
    public void enterElseBlock(javaMinusMinusParser.ElseBlockContext ctx) {

    }

    @Override
    public void exitElseBlock(javaMinusMinusParser.ElseBlockContext ctx) {

    }

    @Override
    public void enterWhileBlock(javaMinusMinusParser.WhileBlockContext ctx) {

    }

    @Override
    public void exitWhileBlock(javaMinusMinusParser.WhileBlockContext ctx) {

    }

    @Override
    public void enterExpressionOrString(javaMinusMinusParser.ExpressionOrStringContext ctx) {

    }

    @Override
    public void exitExpressionOrString(javaMinusMinusParser.ExpressionOrStringContext ctx) {

    }

    @Override
    public void enterExpression(javaMinusMinusParser.ExpressionContext ctx) {

    }

    @Override
    public void exitExpression(javaMinusMinusParser.ExpressionContext ctx) {

    }

    @Override
    public void enterArrayAccessExpression(javaMinusMinusParser.ArrayAccessExpressionContext ctx) {

    }

    @Override
    public void exitArrayAccessExpression(javaMinusMinusParser.ArrayAccessExpressionContext ctx) {

    }

    @Override
    public void enterArrayLengthExpression(javaMinusMinusParser.ArrayLengthExpressionContext ctx) {

    }

    @Override
    public void exitArrayLengthExpression(javaMinusMinusParser.ArrayLengthExpressionContext ctx) {

    }

    @Override
    public void enterMethodCallExpression(javaMinusMinusParser.MethodCallExpressionContext ctx) {

    }

    @Override
    public void exitMethodCallExpression(javaMinusMinusParser.MethodCallExpressionContext ctx) {

    }

    @Override
    public void enterPowExpression(javaMinusMinusParser.PowExpressionContext ctx) {

    }

    @Override
    public void exitPowExpression(javaMinusMinusParser.PowExpressionContext ctx) {

    }

    @Override
    public void enterMulExpression(javaMinusMinusParser.MulExpressionContext ctx) {

    }

    @Override
    public void exitMulExpression(javaMinusMinusParser.MulExpressionContext ctx) {

    }

    @Override
    public void enterAddExpression(javaMinusMinusParser.AddExpressionContext ctx) {

    }

    @Override
    public void exitAddExpression(javaMinusMinusParser.AddExpressionContext ctx) {

    }

    @Override
    public void enterSubExpression(javaMinusMinusParser.SubExpressionContext ctx) {

    }

    @Override
    public void exitSubExpression(javaMinusMinusParser.SubExpressionContext ctx) {

    }

    @Override
    public void enterLtExpression(javaMinusMinusParser.LtExpressionContext ctx) {

    }

    @Override
    public void exitLtExpression(javaMinusMinusParser.LtExpressionContext ctx) {

    }

    @Override
    public void enterGtExpression(javaMinusMinusParser.GtExpressionContext ctx) {

    }

    @Override
    public void exitGtExpression(javaMinusMinusParser.GtExpressionContext ctx) {

    }

    @Override
    public void enterAndExpression(javaMinusMinusParser.AndExpressionContext ctx) {

    }

    @Override
    public void exitAndExpression(javaMinusMinusParser.AndExpressionContext ctx) {

    }

    @Override
    public void enterEmpty(javaMinusMinusParser.EmptyContext ctx) {

    }

    @Override
    public void exitEmpty(javaMinusMinusParser.EmptyContext ctx) {

    }

    @Override
    public void enterNotExpression(javaMinusMinusParser.NotExpressionContext ctx) {

    }

    @Override
    public void exitNotExpression(javaMinusMinusParser.NotExpressionContext ctx) {

    }

    @Override
    public void enterObjectInstantiationExpression(javaMinusMinusParser.ObjectInstantiationExpressionContext ctx) {

    }

    @Override
    public void exitObjectInstantiationExpression(javaMinusMinusParser.ObjectInstantiationExpressionContext ctx) {

    }

    @Override
    public void enterArrayInstantiationExpression(javaMinusMinusParser.ArrayInstantiationExpressionContext ctx) {

    }

    @Override
    public void exitArrayInstantiationExpression(javaMinusMinusParser.ArrayInstantiationExpressionContext ctx) {

    }

    @Override
    public void enterIntArrayInstantiationExpression(javaMinusMinusParser.IntArrayInstantiationExpressionContext ctx) {

    }

    @Override
    public void exitIntArrayInstantiationExpression(javaMinusMinusParser.IntArrayInstantiationExpressionContext ctx) {

    }

    @Override
    public void enterIntLitExpression(javaMinusMinusParser.IntLitExpressionContext ctx) {

    }

    @Override
    public void exitIntLitExpression(javaMinusMinusParser.IntLitExpressionContext ctx) {

    }

    @Override
    public void enterBooleanLitExpression(javaMinusMinusParser.BooleanLitExpressionContext ctx) {

    }

    @Override
    public void exitBooleanLitExpression(javaMinusMinusParser.BooleanLitExpressionContext ctx) {

    }

    @Override
    public void enterNullLitExpression(javaMinusMinusParser.NullLitExpressionContext ctx) {

    }

    @Override
    public void exitNullLitExpression(javaMinusMinusParser.NullLitExpressionContext ctx) {

    }

    @Override
    public void enterIdentifierExpression(javaMinusMinusParser.IdentifierExpressionContext ctx) {

    }

    @Override
    public void exitIdentifierExpression(javaMinusMinusParser.IdentifierExpressionContext ctx) {

    }

    @Override
    public void enterThisExpression(javaMinusMinusParser.ThisExpressionContext ctx) {

    }

    @Override
    public void exitThisExpression(javaMinusMinusParser.ThisExpressionContext ctx) {

    }

    @Override
    public void enterParenExpression(javaMinusMinusParser.ParenExpressionContext ctx) {

    }

    @Override
    public void exitParenExpression(javaMinusMinusParser.ParenExpressionContext ctx) {

    }

    @Override
    public void enterVariableDeclaration(javaMinusMinusParser.VariableDeclarationContext ctx) {

    }

    @Override
    public void exitVariableDeclaration(javaMinusMinusParser.VariableDeclarationContext ctx) {

    }

    @Override
    public void enterPrintStatement(javaMinusMinusParser.PrintStatementContext ctx) {
        String content = ctx.expressionOrString().getText();
        printIndented("PRINT " + content);
    }

    @Override
    public void exitPrintStatement(javaMinusMinusParser.PrintStatementContext ctx) {

    }

    @Override
    public void enterIfElseStatement(javaMinusMinusParser.IfElseStatementContext ctx) {
        printIndented("IF");
        indentation++;
        printIndented("CONDITION " + ctx.expression().getText());
        printIndented("BODY");
        indentation++;
    }

    @Override
    public void exitIfElseStatement(javaMinusMinusParser.IfElseStatementContext ctx) {
        indentation--;
        if (ctx.ELSE() != null) {
            printIndented("ELSE");
            indentation++;
            printIndented("BODY");
            indentation--;
        }
        indentation--;
    }

    @Override
    public void enterWhileStatement(javaMinusMinusParser.WhileStatementContext ctx) {

    }

    @Override
    public void exitWhileStatement(javaMinusMinusParser.WhileStatementContext ctx) {

    }

    @Override
    public void enterForStatement(javaMinusMinusParser.ForStatementContext ctx) {
        printIndented("FOR");
        indentation++;
        if (ctx.localDeclaration() != null) {
            String type = ctx.localDeclaration().type().getText();
            String name = ctx.localDeclaration().Identifier().getText();
            String value = ctx.localDeclaration().expression() != null ? ctx.localDeclaration().expression().getText() : "0";
            printIndented("DECLARE " + type + " " + name + " = " + value);
        }
        printIndented("CONDITION " + ctx.expression(0).getText());
        printIndented("INCREMENT " + ctx.expression(1).getText());
        printIndented("BODY");
        indentation++;
    }

    @Override
    public void exitForStatement(javaMinusMinusParser.ForStatementContext ctx) {
        indentation--;
        indentation--;
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}

















