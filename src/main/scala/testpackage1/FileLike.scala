package testpackage1

/**
  * Created by aschwartz on 4/7/16.
  */
/*
class FileLike {
  def synchronize[F <: FileLike, T <: FileLike](from: F, to: T): Unit = {
    def synchronizeFile(file1: F, file2: T): Unit = file2.writeContent(file1.content)
    def synchronizeDirectory(dir1: F, dir2: T): Unit = {
      def findFile(file: FileLike, directory: FileLike): Option[FileLike] =
        (for {file2 <- directory.children
              if file.name == file2.name
        } yield file2).headOption
      for (file1 <- dir1.children) {
        val file2 = findFile(file1, dir2).
          getOrElse(dir2.child(file1.name))
        if (file1.isDirectory) {
          file2.mkdirs()
        }
        synchronize[F, T](file2, file1)
      }
    }
    if (from.isDirectory) {
      synchronizeDirectory(from, to)
    } else {
      synchronizeFile(from, to)
    }
  }
}
*/
