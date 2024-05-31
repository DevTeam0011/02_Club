import imgFutbol1 from '../public/imagenes/football-1275123_1280.jpg'
import imgrugby2 from '../public/imagenes/kids-56952_1280.jpg'
import imgpaddle3 from '../public/imagenes/paddle-tennis-6612340_1280.jpg'
import imgchicos4 from '../public/imagenes/hockey-3386656_1280.jpg'


export const Galeria = () => {
  return (
    <>
    <div className='containerimg'>
    <img src={imgFutbol1} alt="Futbol" />
    <img src={imgrugby2} alt="Rugby" />
    <img src={imgpaddle3} alt="Paddle" />
    <img src={imgchicos4} alt="Kids" />
    </div>
    
    
    </>
  )
}
