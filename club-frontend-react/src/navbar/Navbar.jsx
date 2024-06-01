import logo from '../../public/imagenes/football-1275123_1280.jpg'

export const Navbar = () => {
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-warning" >
        <div className="container-fluid">
          <a className="navbar-brand" href="#"></a>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="animated slideInLeft"  ><img src={logo} alt="" className='logonavbar' /></li>
              {/* <li className="nav-item">
          <a className="nav-link active" aria-current="page" href="#">Inicio</a>
        </li> */}
              <li  className="nav-item animated slideInLeft " >
                <a className="nav-link active" aria-current="page" href="#">Inicio</a>
              </li>
              
                <li className="nav-item animated slideInLeft">
                  <a className="nav-link" href="#">Instalaciones</a>
                </li>
                <li className="nav-item dropdown animated slideInLeft">
                  <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Actividades
                  </a>
                  <ul className="dropdown-menu">
                    <li><a className="dropdown-item" href="#">Futbol</a></li>
                    <li><hr className="dropdown-divider" /></li>
                    <li><a className="dropdown-item" href="#">Rugby</a></li>
                    <li><hr className="dropdown-divider" /></li>
                    <li><a className="dropdown-item" href="#">Basquet</a></li>
                    <li><hr className="dropdown-divider" /></li>
                    <li><a className="dropdown-item" href="#">Natación</a></li>

                    <li><hr className="dropdown-divider " /></li>
                    <li><a className="dropdown-item" href="#">Voley</a></li>
                  </ul>
                </li>
                
            </ul>
          


            <button className="btn btn-outline-dark" type="submit">Iniciar Sesión</button>
            <button className="btn btn-outline-dark" type="submit">Registrate</button>

          </div>
        </div>
      </nav>
    </div>
  )
}
